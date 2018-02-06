// AJAX calls

/*function getChildFormula(id) {
    //alert("You clicked the AJAX call for " + id);

    $.ajax({
      url: "http://localhost:8080/childFormula/5/Volume",
      //data: data,
      success: success(),
      dataType: json
    });
}

function success() {
    alert("successfully got data with AJAX!");
}*/

// Formula function calls that can will be the callback methods for the webpage's views.

function BodyMassIndex() {
    kg = document.getElementsByName('Body Mass Index - kg')[0].value;
    m2 = document.getElementsByName('Body Mass Index - m2')[0].value;

    //console.log(kg);
    //console.log(m2);

    // check for nulls
    if (kg === null || m2 === null) {
        console.log("kg or m2 were null.")
    }

    // check for text
    if (isNaN(kg) || isNaN(m2)) {
        alert("You must input a number!");
        //console.log("kg:  " + isNaN(kg));
        //console.log("m2:  " + isNaN(m2));
    }

    //return kg / m2;
    document.getElementById('Body Mass Index-result').value = parseInt(kg) / parseInt(m2);
    //alert(parseInt(kg) / parseInt(m2));
    //console.log(parseInt(kg) / parseInt(m2));
}