  $(document).ready(function(){
            alert("Hello,,,,");
            var ownerName = $("#owner").val();
            var projName = $("#project").val();
            alert("Hello,,,," + ownerName + "/" + projName);

            getCommitters(ownerName, projName);


  });

  function getCommitters(var ownerName,var projName) {
               var fail = 30;
               var pass = 70;
       		Highcharts.chart('container', {
       			chart : {
       				type : 'pie',
       				options3d : {
       					enabled : true,
       					alpha : 50,
       					beta : 0
       				}
       			},
       			title : {
       				text : 'Result Status'
       			},
       			tooltip : {
       				pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
       			},
       			plotOptions : {
       				pie : {
       					allowPointSelect : true,
       					cursor : 'pointer',
       					depth : 35,
       					dataLabels : {
       						enabled : true,
       						format : '{point.name}'
       					}
       				}
       			},
       			series : [ {
       				type : 'pie',
       				name : 'Ratio',
       				data : [ [ 'Success', [[pass]] ], [ 'Failure', [[fail]] ]  ]
       			} ]
       		});
  }

  function getData(result){
    const dataArray=[];
    login = [];
    contributions = [];
     result.forEach(function(dt){
              login.push(dt.login);
              contributions.push(dt.contributions);

              alert(dt.login);
      });

    });

    dataArray.push(login,contributions);
  }

  function getCommits(ownerName,projName) {
          $.ajax({
           url:'/search/commits/'+ownerName+'/'+projName,
           type:"GET",
           success:function(result){
             console.log(result);

           },
           error:function(err){
               console.log(err);
           }
       });
    }

    function getDataCount(result){
        const dataArray = [];

        result.forEach(function(dt){
              dataArray.push(dt.author.login);
        });
      console.log("data:" + dataArray);

      if (array instanceof Array) {
                          array.forEach(function (v, i) {
                              if (!result[v]) {
                                  result[v] = [i];
                              } else {
                                  result[v].push(i);
                              }
                          });
                          Object.keys(result).forEach(function (v) {
                              result[v] = {"index": result[v], "length": result[v].length};
                          });
                      }
    }

    function createPieHighChart(data){
        Highcharts.chart('container', {
            chart: {
                type: 'column'
            },
            title: {
                text: 'Commits Contribution'
            },
            subtitle: {
                text: 'Base on the latest commits'
            },
            xAxis: {
                categories: [[${surveyMap.keySet()}]],
                crosshair: true
            },
            yAxis: {
                min: 0,
                max:100,
                title: {
                    text: 'Contribution [in %]'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} K</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                name: 'Contributors',
                data: data
            }]
        });
    }

     function createBarHighChart(data){
                    Highcharts.chart('container', {
                       chart: {
                           type: 'column'
                       },
                       title: {
                           text: 'Technology Popularity In India'
                       },
                       subtitle: {
                           text: 'All Details is not true its a dummy Map'
                       },
                       xAxis: {
                           categories: ["Java", "DevOps", "Python"],
                           crosshair: true
                       },
                       yAxis: {
                           min: 0,
                           max:100,
                           title: {
                               text: 'Technology rating [in %]'
                           }
                       },
                       tooltip: {
                           headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                           pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                           '<td style="padding:0"><b>{point.y:.1f} K</b></td></tr>',
                           footerFormat: '</table>',
                           shared: true,
                           useHTML: true
                       },
                       plotOptions: {
                           column: {
                               pointPadding: 0.2,
                               borderWidth: 0
                           }
                       },
                       series: [{
                           name: 'Technology',
                           data: [40, 25, 20]
                       }]
                   });
               }