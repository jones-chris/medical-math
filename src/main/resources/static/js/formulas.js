// Formula function calls that can will be the callback methods for the webpage's views.

function BodyMassIndex() {
    kg = document.getElementById('Body Mass Index - kg').value;
    m2 = document.getElementById('Body Mass Index - m2').value;

    console.log(kg);
    console.log(m2);

    // check for nulls
    if (kg === null || m2 === null) {
        console.log("kg or m2 were null.")
    }

    // check for text
    if (isNaN(kg) || isNaN(m2)) {
        console.log("kg:  " + isNaN(kg));
        console.log("m2:  " + isNaN(m2));
    }

    //return kg / m2;
    alert(parseInt(kg) / parseInt(m2));
    console.log(parseInt(kg) / parseInt(m2));
}