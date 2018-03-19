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
            if (i === 0) {
                html += '<div style="display: inline-flex;">'; //class="form-group"
            }

            html += '<p id="' + data.childFormulas[i].id + '">' + data.childFormulas[i].name + '</p>';

            html += '<input class="form-control" type="text" ';
            html += 'id="' + data.childFormulas[i].id + '" ';
            html += 'name="' + data.name + ' - ' + data.childFormulas[i].name + '" ';
            html += 'placeholder="' + data.childFormulas[i].name + ' ">'

            if (data.childFormulas[i].hasChildren) {
                html += '<img src="/images/drill_arrow.svg" height="30px" onclick="getChildFormula(' + data.childFormulas[i].id + ')"/>'
            }

            //var newFormulaName = data.childFormulas[i].name.replace(/\s/g, '');
            //html += '<button type="button" th:onclick="' + newFormulaName + '()">Calculate</button>';


            // get parent formula name and add Calculate button if child formula is the last child formula.
            if (i === data.childFormulas.length - 1) {
                var parentFormula = $( formattedId )[0].name;
                html += '<button type="button" th:onclick="' + parentFormula + '()">Calculate</button>';
                html += '<label class="col-form-label" for="' + data.childFormulas[i].name + '-result">Result:</label>';
                html += '<input class="form-control" type="text" id="' + data.childFormulas[i].name + '-result">';
                html += '</div>';

                // Insert new HTML.
                $( formattedId ).closest('div').after(html);

                // Indent child formula by parentOuterWidth + 50px.
//                var childFormattedId = '#' + data.childFormulas[i].id;
//                var newChildPaddingLeft = parentOuterWidth + 50;
//                $( childFormattedId ).parent().css('padding-left', newChildPaddingLeft + 'px');
            }

            // Reset variable for next loop.
            //html = "";
        }
      },
      dataType: 'json'
    });
}

function success(data) {
    //alert("successfully got data with AJAX!");
    alert(data);
}