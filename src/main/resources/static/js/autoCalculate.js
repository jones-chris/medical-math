//function attachBlurToInputBoxes() {
//    var allInputs = $( ":input" );
//
//    for (var input in allInputs) {
//        input.blur();
//    }
//
//}

//// calculate formula after blur (this function is meant to be assigned to an onblur event for input boxes.
//function calculateAfterBlur() {
//
//    // get in-memory cache of master_formula table (formula_id and formula_name columns) to map id to name in order to call formulas.js.
//
//    // while not null (closest() function will return null if it can't find anymore matching elements)
//    var divIsChildOrTopLevel = false;
//    while (! divIsChildOrTopLevel) {
//        var parentEl = document.getElementById(this.id).parentElement;
//        if (parentEl.id.indexOf('topLevel-')) {
//            // get id from id attribute
//            var formulaId = parentEl.id.substring(8, parentEl.id.length - 8); // 8 is the length of 'topLevel-'
//
//            // lookup value of id in local storage
//            var formulaName = window.localStorage.getItem(formulaId);
//
//            // remove spaces in formula name
//            formulaName.replace(' ', '');
//            formulaName += '()';
//
//            // call formula in formulas.js
//
//        }
//    }
//    // get closest div
//
//        // if div contains "topLevel" in id
//            //call formulas.js function based on div's name
//        // if div contains "children" in div id
//            // get all inputs in div
//            // if all inputs contain a number (! isNaN check)
//                // get div's hidden element's (h1 element) inner HTML (which is the parent id element)
//                // get function name from local storage where formulas id and name are stored as key-value pairs
//                // call formulas.js function
//        // else go up to next closest div and try again
//
//}

