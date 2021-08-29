var routerApp = angular.module('routerApp', ['ui.router']);

routerApp.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/home');

    $stateProvider.state('home', {
        url: '/home',
        templateUrl: 'views/index.html'

    }).state('serieCreate', {
        url: '/serie/create',
        controller: 'seriesController',
        templateUrl: 'views/Serie/createSerie.html'
    }).state('serieList', {
        url: '/series',
        controller: 'seriesController',
        templateUrl: 'views/Serie/seriesLists.html'
    }).state('serieEdit', {
        url: '/series/edit/:id',
        controller: 'seriesController',
        templateUrl: 'views/Serie/createSerie.html'
    }).state("seriesInfo", {
        url: '/series/:id',
        controller: 'seriesController',
        templateUrl: 'views/Serie/serieInfo.html'

    }).state('atoreList', {
        url: '/atores',
        controller: 'atoresController',
        templateUrl: 'views/Atore/atoresLists.html'
    }).state('atoreEdit', {
        url: '/atores/edit/:id',
        controller: 'atoresController',
        templateUrl: 'views/Atore/createAtore.html'
    }).state('atoreCreate', {
        url: '/atores/create',
        controller: 'atoresController',
        templateUrl: 'views/Atore/createAtore.html'


    }).state('temporadaList', {
        url: '/temporadas',
        controller: 'temporadasController',
        templateUrl: 'views/Temporadas/temporadasLists.html'
    }).state('temporadaCreate', {
        url: '/temporadas/create',
        controller: 'temporadasController',
        templateUrl: 'views/Temporadas/createTemporada.html'
    }).state('temporadaEdit', {
        url: '/temporadas/edit/:id',
        controller: 'temporadasController',
        templateUrl: 'views/Temporadas/createTemporada.html'

    }).state('episodiosList', {
        url: '/episodios',
        controller: 'episodiosController',
        templateUrl: 'views/Episodios/episodiosLists.html'
    }).state('episodiosCreate', {
        url: '/episodios/create',
        controller: 'episodiosController',
        templateUrl: 'views/Episodios/createEpisodio.html'
    }).state('episodiosEdit', {
        url: '/episodios/edit/:id',
        controller: 'episodiosController',
        templateUrl: 'views/Episodios/createEpisodio.html'
    })
}).
constant("globalConfig", {
    apiAddress: 'http://localhost:3000/api'
});