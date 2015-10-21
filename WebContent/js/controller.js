
var crudAtendimento = angular.module("crudAtendimento", ["ngResource"]);

crudAtendimento.controller("AtendimentoController", ["$resource", "$scope", function($resource, $scope){
	
	
	var angularResource = $resource("/SistemaAtendimento/rest/atendimento");
	var angularResourceParam = $resource("/SistemaAtendimento/rest/atendimento/:id" , {id : "@id"});
	
	$scope.salvar = function(){
		
		if(!$scope.atendimento.id){
			var newResource = new angularResource($scope.atendimento); 
			newResource.$save(function(){
				$scope.atendimentos.push(newResource);
				$scope.novo();
			});
		}  else{
			$scope.editar();
		}
	}
	
	$scope.editar = function() {
		var newResource = new angularResource($scope.atendimento);
		newResource.$save(function(){
			$scope.novo();
			$scope.carregaLista();
		});
	}
	
	$scope.excluir = function() {
		var newResource = new angularResourceParam($scope.atendimento);
		
		newResource.$delete(function(){
			$scope.atendimentos.splice($scope.atendimentos.indexOf($scope.atendimento), 1);
			$scope.novo();
		});
		
	}
	
	$scope.novo = function(){
		$scope.atendimento = "";
	}
	
	$scope.seleciona = function(atendimento) {
		$scope.atendimento = angular.copy(atendimento);
	}
	
	$scope.carregaLista = function(){
		var query = angularResource.query()
		query.$promise.then(function(data){
			$scope.atendimentos = data;
		});
	}
	
	$scope.carregaLista();

}]);