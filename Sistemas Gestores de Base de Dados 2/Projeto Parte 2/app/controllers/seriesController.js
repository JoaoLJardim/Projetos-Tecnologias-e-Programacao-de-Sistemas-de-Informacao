routerApp.controller('seriesController', function ($scope, $http, $state, $stateParams, globalConfig) {

    $scope.deleteSerie = function (serie) {
        $http({
            method: "DELETE",
            url: globalConfig.apiAddress + "/series/" + serie,
        }).then(function mySuccess(response) {
            $http({
                method: "GET",
                url: globalConfig.apiAddress + "/series"
            }).then(function mySuccess(response) {
                $scope.series = response.data;
                $scope.error = "Serie Eliminada com sucesso";
            }, function myError(response) {
            });
        }, function myError(response) {
        });
    }

    $scope.addfield = function () {
        $scope.inputs.push({"id": $scope.inputs.length})
    }

    $scope.removefield = function (id) {
        $scope.serie.diretores.splice(id, 1)
        $scope.inputs = [];
        for (i = 0; i < $scope.serie.diretores.length; i++) {
            $scope.inputs.push({id: i})
        }
    }

    $scope.saveData = function (serie) {
        if ($state.current.name === 'serieCreate') {

            var serieBody = serie;

            if (serieBody.temporada_id === undefined || serieBody.temporada_id.length < 1) {
                $scope.error = "Insira pelo menos uma temporada";
                return;
            }

            $http({
                method: "GET",
                url: globalConfig.apiAddress + "/series"
            }).then(function mySuccess(response) {
                var id = 0;
                for (i = 0; i < response.data.length; i++) {
                    if (response.data[i].serie_id > id) {
                        id = response.data[i].serie_id;
                    }
                }
                serieBody.serie_id = id + 1;

                for (i = 0; i < serieBody.diretores.length; i++) {
                    serieBody.diretores[i].diretor_id = i;
                }

                $http({
                    method: "POST",
                    url: globalConfig.apiAddress + "/series",
                    data: serieBody,
                }).then(function mySuccess(response) {
                    if (response.data === "error") {
                        $scope.error = "Ocureu um erro ao criar a Serie";
                        return;
                    }
                    $scope.error = "Serie Criada com sucesso";
                }, function myError(response) {
                    $scope.error = "Ocureu um erro criando a serie";
                });

            }, function myError(response) {
            });

        } else if ($state.current.name === 'serieEdit') {

            if (serie.temporada_id === undefined || serie.temporada_id.length < 1) {
                $scope.error = "Insira pelo menos uma temporada";
                return;
            }

            for (i = 0; i < serie.diretores.length; i++) {
                serie.diretores[i].diretor_id = i;
            }

            $http({
                method: "POST",
                url: globalConfig.apiAddress + "/series/" + $stateParams.id,
                data: serie,
            }).then(function mySuccess(response) {
                $scope.error = "Serie Editada com sucesso";
            }, function myError(response) {
                $scope.error = "Ocureu um erro editando a serie";
            });
        }
        serie = null;
    };

    if ($state.current.name === 'seriesInfo') {
        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/series/" + $stateParams.id
        }).then(function mySuccess(response) {
            $scope.serie = response.data;
        }, function myError(response) {
        });
    }

    if ($state.current.name === 'serieList') {
        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/series"
        }).then(function mySuccess(response) {
            $scope.series = response.data;
        }, function myError(response) {
        });
    } else if ($state.current.name === 'serieEdit') {

        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/series/" + $stateParams.id
        }).then(function mySuccess(response) {
            $scope.serie = response.data;
            $scope.inputs = []
            for (i = 0; i < response.data.diretores.length; i++) {
                $scope.inputs.push({id: i})
            }

            $scope.serie.data = new Date(response.data.data);
        }, function myError(response) {

        });

        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/temporadas/"
        }).then(function mySuccess(response) {
            $scope.temporadas = response.data;
        }, function myError(response) {

        });

    } else if ($state.current.name === 'serieCreate') {
        $http({
            method: "GET",
            url: globalConfig.apiAddress + "/temporadas/"
        }).then(function mySuccess(response) {
            $scope.temporadas = response.data;
            $scope.inputs = [{"id": 0}];
            $scope.serie = {"diretores": []}
        }, function myError(response) {

        });
    }

})
;