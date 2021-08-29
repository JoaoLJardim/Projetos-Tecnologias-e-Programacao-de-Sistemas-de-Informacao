routerApp.controller('episodiosController', function ($scope, $http, $state, $stateParams, globalConfig) {

    $scope.deleteEpisodio = function (atore) {
        $http({
            method: "DELETE",
            url: globalConfig.apiAddress + "/episodios/" + atore,
        }).then(function mySuccess(response) {
            $http({
                method: "GET",
                url: globalConfig.apiAddress + "/episodios"
            }).then(function mySuccess(response) {
                $scope.episodios = response.data;
                $scope.error = "Episodio Eliminado com sucesso";
            }, function myError(response) {

            });

        }, function myError(response) {

        });
    }

    $scope.saveepisodioData = function(episodio) {
        if ($state.current.name === 'episodiosCreate')
        {

            if (episodio.temporada_id === undefined || episodio.temporada_id === "") {
                $scope.error = "Insira uma temporada";
                return;
            }


            $http({
                method: "POST",
                url: globalConfig.apiAddress + "/episodios",
                data: episodio,
            }).then(function mySuccess(response) {
                if (response.data === "error") {
                    $scope.error = "Ocureu um erro ao criar o Episodio";
                    return;
                }
                $scope.error = "Episodio criada com sucesso";
            }, function myError(response) {
                $scope.error = "Ocureu um erro ao criar o Episodio";
            });
        }
        else if ($state.current.name === 'episodiosEdit')
        {

            console.log(episodio.temporada_id)

            if (episodio.temporada_id === undefined || episodio.temporada_id === "") {
                $scope.error = "Insira uma temporada";
                return;
            }

            $http({
                method: "POST",
                url: globalConfig.apiAddress + "/episodios/" + $stateParams.id,
                data: episodio,
            }).then(function mySuccess(response) {
                $scope.error = "Episodio editado com sucesso";
            }, function myError(response) {
                $scope.error = "Ocureu um erro ao editar o Episodio";
            });
        }
    };


    if ($state.current.name === 'episodiosList') {
        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/episodios"
        }).then(function mySuccess(response) {
            $scope.episodios = response.data;
        }, function myError(response) {

        });
    } else if ($state.current.name === 'episodiosEdit') {
        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/episodios/" + $stateParams.id
        }).then(function mySuccess(response) {
            $scope.episodio = response.data;
        }, function myError(response) {

        });

        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/temporadas/"
        }).then(function mySuccess(response) {
            $scope.temporadas = response.data;
        }, function myError(response) {

        });
    } else if ($state.current.name === 'episodiosCreate'){
        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/temporadas/"
        }).then(function mySuccess(response) {
            $scope.temporadas = response.data;
        }, function myError(response) {

        });
    }
});