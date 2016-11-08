<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
<head>
	<style>
		.ok {
			background-color: #b0ffb0;
		}
		.alarm {
			background-color: red;
		}
		.cut {
			background-color: yellow;
		}
		.tampered {
			background-color: yellow;
		}
	</style>
</head>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-resource.min.js"></script>
<script>
var app = angular.module("alarmModule", []); 
app.controller("alarmController", function($scope,  $http, $timeout, $window) {
  // Function to get the data
  
  $scope.stop = function() {
	 $http.jsonp("<@spring.url '/alarm-backend/stop'/>");
  }

  $scope.arm = function() {
	 $http.jsonp("<@spring.url '/alarm-backend/arm'/>");
  }
  
  $scope.getData = function(){
	 $http.jsonp("<@spring.url '/alarm-backend'/>");
  };
  
  $window.jsonp = function(data) {
      $scope.alarm = data;
  };

  // Function to replicate setInterval using $timeout service.
  $scope.intervalFunction = function(){
    $timeout(function() {
      $scope.getData();
      $scope.intervalFunction();
    }, 1000)
  };

  $scope.getData();
  // Kick off the interval
  $scope.intervalFunction();
});
</script>
<body>
	<div>
		<div class="nappali">
		</div>
		<div class="halo">
		</div>
	</div>
	<div ng-app="alarmModule" ng-controller="alarmController">
		<div>
			<a ng-href='#arm' ng-click='arm()' >Arm</a>
			<a ng-href='#stop' ng-click='stop()' >Stop</a>
		</div>
		Current state: 
		<span ng-switch on="alarm.state">
			<span ng-switch-when="0">Stand by</span>
			<span ng-switch-when="1">Armed</span>
			<span ng-switch-when="2">Alert</span>
			<span ng-switch-when="3">To be armed</span>
		</span>
		<div>
			<div style="float:left; padding: 10px;" ng-repeat="item in alarm.sensors" ng-class="{'ok' : item.status == 1, 'alarm' : item.status == 0, 'cut' : item.status == 2, 'tampered' : item.status == 3}">{{item.name}}</td>
		</div>
		<div style="clear: both;">
		<table>
			<tr ng-repeat="item in alarm.log | orderBy:'-'">
				<td>-{{item.timestamp}} min</td>
				<td>{{item.event}}</td>
			</tr>
		</table>
		</div>
	</div>
</body>
</html>
