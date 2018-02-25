function getChildFormula(id) {
    $.ajax({
      url: "http://localhost:8080/childFormula",
      data: {
        id: id,
      },
      success: function(data) {
        var html = "";
        var formattedId = '#'+ id;
        var parentOuterWidth = parseInt($( formattedId ).css('padding-left'));

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

            // Insert new HTML.
            $( formattedId ).closest('div').after(html);

            // Indent child formula by parentOuterWidth + 50px.
            var childFormattedId = '#' + data.childFormulas[i].id;
            var newChildPaddingLeft = parentOuterWidth + 50;
            $( childFormattedId ).parent().css('padding-left', newChildPaddingLeft + 'px');
        }
      },
      dataType: 'json'
    });
}

function success(data) {
    //alert("successfully got data with AJAX!");
    alert(data);
}