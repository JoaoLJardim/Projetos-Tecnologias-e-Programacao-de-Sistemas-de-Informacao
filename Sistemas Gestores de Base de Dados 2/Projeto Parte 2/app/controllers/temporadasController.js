routerApp.controller('temporadasController', function ($scope, $http, $state, $stateParams, globalConfig) {

    $scope.deletetemporadas = function (temporada) {
        $http({
            method: "DELETE",
            url: globalConfig.apiAddress + "/temporadas/" + temporada,
        }).then(function mySuccess(response) {
            $http({
                method: "GET",
                url: globalConfig.apiAddress + "/temporadas"
            }).then(function mySuccess(response) {
                $scope.temporadas = response.data;
                $scope.error = "Temporada Eliminada com sucesso";
            }, function myError(response) {

            });

        }, function myError(response) {

        });
    }

    $scope.saveTemporadaData = function (temporada) {
        if ($state.current.name === 'temporadaCreate') {

            var temporadaBody = temporada;

            $http({
                method: "GET",
                url: globalConfig.apiAddress + "/temporadas"
            }).then(function mySuccess(response) {
                var id = 0;
                for (i = 0; i < response.data.length; i++) {
                    if (response.data[i].temporada_id > id) {
                        id = response.data[i].temporada_id;
                    }
                }

                temporadaBody.temporada_id = id + 1;

                if (temporada.ator_id === undefined || temporada.ator_id.length < 1) {
                    $scope.error = "Insira pelo menos um Ator";
                    return;
                }

                $http({
                    method: "POST",
                    url: globalConfig.apiAddress + "/temporadas",
                    data: temporadaBody,
                }).then(function mySuccess(response) {
                    if (response.data === "error") {
                        $scope.error = "Ocureu um erro ao criar a Temporada";
                        return;
                    }
                    $scope.error = "Temporada criada com sucesso";
                }, function myError(response) {
                    $scope.error = "Ocureu um erro ao criar a Temporada";
                });

            }, function myError(response) {
            });

        } else if ($state.current.name === 'temporadaEdit') {

            if (temporada.ator_id === undefined || temporada.ator_id.length < 1) {
                $scope.error = "Insira pelo menos um Ator";
                return;
            }

            $http({
                method: "POST",
                url: globalConfig.apiAddress + "/temporadas/" + $stateParams.id,
                data: temporada,
            }).then(function mySuccess(response) {
                $scope.error = "Temporada editada com sucesso";
            }, function myError(response) {
                $scope.error = "Ocureu um erro ao editar a Temporada";
            });
        }
    };


    if ($state.current.name === 'temporadaList') {
        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/temporadas"
        }).then(function mySuccess(response) {
            $scope.temporadas = response.data;
        }, function myError(response) {

        });
    } else if ($state.current.name === 'temporadaEdit') {
        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/temporadas/" + $stateParams.id
        }).then(function mySuccess(response) {
            $scope.temporada = response.data;
        }, function myError(response) {

        });

        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/atores/"
        }).then(function mySuccess(response) {
            $scope.atores = response.data;
        }, function myError(response) {

        });

    } else if ($state.current.name === 'temporadaCreate') {
        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/atores/"
        }).then(function mySuccess(response) {
            $scope.atores = response.data;
        }, function myError(response) {

        });
    }
});