function getChildFormula(id) {
    //alert("You clicked the AJAX call for " + id);

    $.ajax({
      url: "http://localhost:8080/childFormula/5/Volume",
      //data: data,
      success: success(data),
      dataType: 'json'
    });
}

function success(data) {
    //alert("successfully got data with AJAX!");
    alert(data);
}