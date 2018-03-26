// Formula function calls that can will be the callback methods for the webpage's views.
// All functions are meant to take an JSON object similar to args in Java.

//function BodyMassIndex() {
//    kg = document.getElementsByName('Body Mass Index - kg')[0].value;
//    m2 = document.getElementsByName('Body Mass Index - m2')[0].value;
//
//    //console.log(kg);
//    //console.log(m2);
//
//    // check for nulls
//    if (kg === null || m2 === null) {
//        console.log("kg or m2 were null.")
//    }
//
//    // check for text
//    if (isNaN(kg) || isNaN(m2)) {
//        alert("You must input a number!");
//        //console.log("kg:  " + isNaN(kg));
//        //console.log("m2:  " + isNaN(m2));
//    }
//
//    //return kg / m2;
//    document.getElementById('Body Mass Index-result').value = parseInt(kg) / parseInt(m2);
//    //alert(parseInt(kg) / parseInt(m2));
//    //console.log(parseInt(kg) / parseInt(m2));
//}

$(':input').blur(calculateAfterBlur);

// calculate formula after blur (this function is meant to be assigned to an onblur event for input boxes.
function calculateAfterBlur() {

    // get in-memory cache of master_formula table (formula_id and formula_name columns) to map id to name in order to call formulas.js.

    // while not null (closest() function will return null if it can't find anymore matching elements)
    var divIsChildOrTopLevel = false;
    while (! divIsChildOrTopLevel) {
        var parentEl = document.getElementById(this.id).parentElement;
        if (parentEl.id.indexOf('topLevel-') > -1) {
            divIsChildOrTopLevel = true;
            // get id from id attribute
            var formulaId = parentEl.id.substring(9); // 8 is the length of 'topLevel-'

            // lookup value of id in local storage
            var formulaName = window.localStorage.getItem(formulaId);

            // remove spaces in formula name
            formulaName = formulaName.replace(/\s/g, '');

            // get relevant input boxes in div
            var formattedParentElId = '#' + parentEl.id;
            var inputs = $(formattedParentElId + ' >:input');

            var args = [];
            for (var i=0; i<inputs.length; i++) {
                if (inputs[i].value === "") { // an input box is missing a value, so do not calculate.
                    return;
                } else {
                    args.push(inputs[i].value);
                }
            }

            var func = window[formulaName];
            var result = func.apply(this, args);

            // call formula in formulas.js
            //var func = new Function(formulaName);
            //var result = func.apply(null, args); //try func();

            alert(result);

            // add result after Result label.
            $('#result-' + formulaId).innerHTML = result;
        }
    }
    // get closest div

        // if div contains "topLevel" in id
            //call formulas.js function based on div's name
        // if div contains "children" in div id
            // get all inputs in div
            // if all inputs contain a number (! isNaN check)
                // get div's hidden element's (h1 element) inner HTML (which is the parent id element)
                // get function name from local storage where formulas id and name are stored as key-value pairs
                // call formulas.js function
        // else go up to next closest div and try again

}

function BodyMassIndex(kg, metersSquared) {
    if (paramIsNull(kg) || paramIsNull(metersSquared)) {
        console.log("One of the parameters was null or an empty string.")
        return;
    }

    if (isNaN(kg) || isNaN(metersSquared)) {
        alert("You must input a number!");
        return;
    }

    return parseInt(kg) / parseInt(metersSquared);
}

//=============================================================================================
//
//  PRIVATE METHODS
//
//=============================================================================================

function paramIsNull(param) {
    if (param === null || param === "") {
        return true;
    }
    return false;
}
