function getChildFormula(id) {
    //alert("You clicked the AJAX call for " + id);


    $.ajax({
      url: "http://localhost:8080/childFormula/5/Volume",
      //data: data,
      success: function(data) {
        //alert(data);

        var parentFormulaName = document.getElementById(id).parentElement.getElementsByTagName('p')[0].innerHTML;

        var html = '<h1>';
        html += '<input class="form-control" type="text" ';
        html += 'id="' + data.id + '" ';
        html += 'name="' + parentFormulaName + ' - ' + data.name + '" ';
        html += 'placeholder="' + data.name + ' "/>'

        if (data.hasChildren) {
            html += '<img src="/images/drill_arrow.svg" height="30px" onclick="getChildFormula(' + data.id + ')"/>'
        }

        html += '</h1>';

        //alert(html);

        var formattedId = '#'+ id;
        $( formattedId ).closest('div').after(html);

        //deactivate drilldown arrow control.

      },
      dataType: 'json'
    });
}

function success(data) {
    //alert("successfully got data with AJAX!");
    alert(data);
}