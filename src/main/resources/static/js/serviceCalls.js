function getChildFormula(id) {
    //alert("You clicked the AJAX call for " + id);


    $.ajax({
      url: "http://localhost:8080/childFormula",
      data: {
        id: id,
        //name: 'Volume'
      },
      success: function(data) {
        //alert(data);

        //var parentFormulaName = document.getElementById(id).parentElement.getElementsByTagName('p')[0].innerHTML;

        var html = "";
        for (var i=0; i<data.childFormulas.length; i++) {
            html += '<h1>';
            html += '<input class="form-control" type="text" ';
            html += 'id="' + data.childFormulas[i].id + '" ';
            html += 'name="' + data.name + ' - ' + data.childFormulas[i].name + '" ';
            html += 'placeholder="' + data.childFormulas[i].name + ' "/>'

            if (data.childFormulas[i].hasChildren) {
                html += '<img src="/images/drill_arrow.svg" height="30px" onclick="getChildFormula(' + data.childFormulas[i].id + ')"/>'
            }

            html += '</h1>';
        }

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