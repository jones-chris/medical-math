$.ajax({
      url: "http://localhost:8080/allFormulas",
      success: function(data) {

            var localStorage = window.localStorage;

            localStorage.clear();

            for (var i in data) {
                localStorage.setItem(data[i]['id'], data[i]['name']);
            }

//            //get version key value in local storage
//            var currentVersion = localStorage.getItem('version');
//
//            // if version value is not same as version in postgresql, then clear storage and reload data.
//            var remoteVersion = getDbVersion();
//            if (remoteVersion !== currentVersion) {
//                localStorage.clear();
//
//                for (var i in data) {
//                    localStorage.setItem(data[i]['id'], data[i]['name']);
//                }
//            }
      },
      dataType: 'json'
});


//TODO: CJ instead of making this a separate function, should this just be imbedded in the success callback above?
function getDbVersion() {
    var version;

    $.ajax({
          url: "http://localhost:8080/getDbVersion",
          success: function(data) {
                version = data['value'];
          },
          error: function(xhr, ajaxOptions, thrownError) {
            console.log(thrownError);
          },
          dataType: 'json'
    });

    return version;
}