//function getChildFormula() {
    $.ajax({
      url: "http://localhost:8080/allFormulas",
//      data: {
//        id: id,
//      },
      success: function(data) {
        //prefixes of implementation that we want to test
        window.indexedDB = window.indexedDB || window.mozIndexedDB || window.webkitIndexedDB || window.msIndexedDB;

        //prefixes of window.IDB objects
        window.IDBTransaction = window.IDBTransaction || window.webkitIDBTransaction || window.msIDBTransaction;
        window.IDBKeyRange = window.IDBKeyRange || window.webkitIDBKeyRange || window.msIDBKeyRange

        if (!window.indexedDB) {
            window.alert("Your browser doesn't support a stable version of IndexedDB.")
        }

        var db;
        var request = window.indexedDB.open("newDatabase", 1);

        request.onerror = function(event) {
          console.log("error: ");
        };

        request.onsuccess = function(event) {
          db = request.result;
          console.log("success: "+ db);
        };

        request.onupgradeneeded = function(event) {
            var db = event.target.result;
            var objectStore = db.createObjectStore("formulas", {keyPath: "id"});
            for (var i in data) {
                    objectStore.add(data[i]['name']);
            }
        }

      },
      dataType: 'json'
    });
//}
