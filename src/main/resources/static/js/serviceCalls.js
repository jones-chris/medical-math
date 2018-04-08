function getChildFormula(id) {
    $.ajax({
      url: "http://localhost:8080/childFormula",
      data: {
        id: id,
      },
      success: function(data) {
        var html = "";
        var formattedId = '#input-'+ id;
        var parentOuterWidth = parseInt($( formattedId ).css('padding-left'));

        for (var i=0; i<data.childFormulas.length; i++) {
            if (i === 0) {
                html += '<div id="children-' + id + '">'; //class="form-group"
                html += '<h1 hidden="true" id="parentIdRef">' + 'input-' + id + '</h1>'
            }

            //html += '<div class="form-group form-inline">';
            html +=     '<label id="name-' + data.childFormulas[i].id + ' for="input-' + data.childFormulas[i].id + '">' + data.childFormulas[i].name + '</label>';
            //html +=     '<div>'
            html +=     '<input type="number" ';
            html +=         'id="input-' + data.childFormulas[i].id + '" ';
            html +=         'name="' + data.name + ' - ' + data.childFormulas[i].name + '" >';
            html += '<br/>'
            //html +=         'placeholder="' + data.childFormulas[i].name + ' ">'

            if (data.childFormulas[i].hasChildren) {
                html += '<img id="image-' + data.childFormulas[i].id + '" src="/images/drill_arrow.svg" height="30px" onclick="getChildFormula(' + data.childFormulas[i].id + ')"/>'
            }

            //html +=     '</div>'
            //html += '</div>'

            //var newFormulaName = data.childFormulas[i].name.replace(/\s/g, '');
            //html += '<button type="button" th:onclick="' + newFormulaName + '()">Calculate</button>';

            // get parent formula name and add Calculate button if child formula is the last child formula.
            if (i === data.childFormulas.length - 1) {
                var parentFormula = $( formattedId )[0].name;
//                html +=     '<div style="display: table-cell">';
//                //html += '<button type="button" th:onclick="' + parentFormula + '()">Calculate</button>';
//                html +=         '<p>Result:</p>';
//                html +=         '<input class="form-control" type="text" id="' + data.childFormulas[i].name + '-result">';
//                html +=     '</div>'
                html += '</div>';

                // Insert new HTML.
                //$( formattedId ).closest('div').append(html);
                $(html).insertAfter(formattedId)

                // Add onblur event so that input boxes can fire auto calculate.
                $(childrenId + ' >:input').blur(calculateAfterBlur);
            }

            // Indent children div by parentOuterWidth + 50px.
            var childrenId = '#children-' + id
            var newChildPaddingLeft = parentOuterWidth + 50;
            $( childrenId ).css('padding-left', newChildPaddingLeft + 'px');

        }
      },
      dataType: 'json'
    });
}
