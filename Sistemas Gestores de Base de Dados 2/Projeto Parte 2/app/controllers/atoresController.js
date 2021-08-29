routerApp.controller('atoresController', function ($scope, $http, $state, $stateParams, globalConfig) {

    $scope.deleteAtore = function (atore) {
        $http({
            method: "DELETE",
            url: globalConfig.apiAddress + "/atores/" + atore,
        }).then(function mySuccess(response) {
            $http({
                method: "GET",
                url: globalConfig.apiAddress + "/atores"
            }).then(function mySuccess(response) {
                $scope.atores = response.data;
                $scope.error = "Ator Eliminado com sucesso";
            }, function myError(response) {

            });

        }, function myError(response) {

        });
    }

    $scope.saveAtoreData = function (atore) {
        if ($state.current.name === 'atoreCreate') {
            var atorBody = atore;

            $http({
                method: "GET",
                url: globalConfig.apiAddress + "/atores"
            }).then(function mySuccess(response) {
                var id = 0;
                for (i = 0; i < response.data.length; i++) {
                    if (response.data[i].ator_id > id) {
                        id = response.data[i].ator_id;
                    }
                }

                atorBody.ator_id = id + 1;

                $http({
                    method: "POST",
                    url: globalConfig.apiAddress + "/atores",
                    data: atorBody,
                }).then(function mySuccess(response) {
                    if (response.data === "error") {
                        $scope.error = "Ocureu um erro ao criar o Ator";
                        return;
                    }
                    $scope.error = "Ator criado com sucesso";
                }, function myError(response) {
                    $scope.error = "Ocureu um erro ao criar o Ator";
                });
            }, function myError(response) {
            });
        } else if ($state.current.name === 'atoreEdit') {
            $http({
                method: "POST",
                url: globalConfig.apiAddress + "/atores/" + $stateParams.id,
                data: atore,
            }).then(function mySuccess(response) {
                $scope.error = "Ator editado com sucesso";
            }, function myError(response) {
                $scope.error = "Ocureu um erro ao editar o Ator";
            });
        }
    }
    ;


    if ($state.current.name === 'atoreList') {
        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/atores"
        }).then(function mySuccess(response) {
            $scope.atores = response.data;
        }, function myError(response) {

        });
    } else if ($state.current.name === 'atoreEdit') {
        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/atores/" + $stateParams.id
        }).then(function mySuccess(response) {
            $scope.atore = response.data;
            $state.href("episodiosList");
        }, function myError(response) {

        });
    }
})
;