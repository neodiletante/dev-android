function drawChart(val, chart){                                               
          var st_Value = val;
          var myChart = new FusionCharts(chart, "myChartId", "200", "100", "0", "1");
          myChart.setXMLData("<chart lowerLimit='0' upperLimit='100' lowerLimitDisplay='Bad' " +
          "upperLimitDisplay='Good' numberSuffix='%' showValue='1'>" +
          "<colorRange>" +
          "<color minValue='0' maxValue='75' code='FF654F'/>" +
          "<color minValue='75' maxValue='90' code='F6BD0F'/>" +
          "<color minValue='90' maxValue='100' code='8BBA00'/>" +
          "</colorRange>" +
          "<dials>" +
          //"<dial value='92'/>" +
          "<dial value='" + st_Value + "'/>" +
          "</dials>" +
          "</chart>");
          myChart.render("chartdiv");
}