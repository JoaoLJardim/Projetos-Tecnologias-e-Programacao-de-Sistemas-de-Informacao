<?php

namespace App\Http\Controllers;

use App\Models\Ticket;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Config;
use PayPal\Api\Amount;
use PayPal\Api\Payer;
use PayPal\Api\Payment;
use PayPal\Api\PaymentExecution;
use PayPal\Api\RedirectUrls;
use PayPal\Api\Transaction;
use PayPal\Auth\OAuthTokenCredential;
use PayPal\Exception\PayPalConnectionException;
use PayPal\Rest\ApiContext;

class PaymentController extends Controller
{

    private $apiContext;

    #
    # Author: João Luís Gomes Jardim
    # Payment via Paypal
    # External Library: paypal/rest-api-sdk-php
    #
    
    public function __construct() {
        $payPalConfig = Config::get('paypal');

        $this->apiContext = new ApiContext(
            new OAuthTokenCredential(
                $payPalConfig['client_id'],
                $payPalConfig['secret']
            )
        );
    }

    public function payWithPayPal($id) {
        $ticket = Ticket::findOrFail($id);

        $payer = new Payer();
        $payer->setPaymentMethod('paypal');

        $amount = new Amount();
        $amount->setTotal($ticket->preco);
        $amount->setCurrency('EUR');

        $transaction = new Transaction();
        $transaction->setAmount($amount);
        $transaction->setDescription('Ticket do dia: '.$ticket->data . ', Espreguicadeiras: '.$ticket->espreguicadeiras.', Guarda-Sois: '.$ticket->chapeus. ', Duche:'.$ticket->duche);

        $callBackUrl = url('/paypal/status/'. $ticket->id);
        $redirectUrls = new RedirectUrls();
        $redirectUrls->setReturnUrl($callBackUrl)
            ->setCancelUrl($callBackUrl);

        $payment = new Payment();
        $payment->setIntent('sale')
            ->setPayer($payer)
            ->setTransactions(array($transaction))
            ->setRedirectUrls($redirectUrls);

        try {
            $payment->create($this->apiContext);
            echo $payment;
            return redirect()->away($payment->getApprovalLink());
        } catch (PayPalConnectionException $ex)  {
            echo $ex->getData();
        }
    }

    public function payPalStatus($id, Request $request) {
        $paymentId = $request->input('paymentId');
        $payerId = $request->input('PayerID');
        $token = $request->input('token');

        if (!$paymentId || !$payerId || !$token) {
            return redirect(route('tickets.show' , $id))->with("error", "Não foi possível executar o pagamento!!!");
        }

        $payment = Payment::get($paymentId, $this->apiContext);

        $execution = new PaymentExecution();
        $execution->setPayerId($payerId);

        $result = $payment->execute($execution, $this->apiContext);
        
        if ($result->getState() === 'approved') {
            $ticket = Ticket::findOrFail($id);
            $ticket->estado = "Pago";
            $ticket->save();
            return redirect(route('tickets.show', $id))->with("success", "Pagamento Completo!!!");
        } else {
            return redirect(route('tickets.show', $id))->with("error", "O Pagamento foi cancelado ou ouve algum erro!!!");
        }
    }
}
