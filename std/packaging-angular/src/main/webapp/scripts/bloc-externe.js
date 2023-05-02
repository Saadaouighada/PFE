
(function () {

    function openObject(data) {
        var allowedOrigin = 'http://127.0.0.1:8888';
        
        var serializedData = JSON.stringify(data);
        parent.window.postMessage(serializedData, allowedOrigin);
        console.log("message envoyé : " + serializedData);
    }
    
    $('#message-params').submit(function(e) {
        e.preventDefault();
        openObject($(this).serializeObject());
    });

})();
