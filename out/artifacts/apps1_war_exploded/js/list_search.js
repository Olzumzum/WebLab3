function searchList(form) {

    var searchCriterion = document.getElementById("searchfield").value;
    console.log("Получено значение " + document.getElementById("searchfield").value);
    sendDateAjax(searchCriterion);
}

function sendDateAjax(searchCriterion){
    jQuery.ajax({
        type: 'POST',
        url: 'ProductShowServlet',
        data: {searchCriterion: searchCriterion},
        respons: 'xml',
        success:function (html) {
            console.log("Успешно");
            $('#content').html("page_cake.jsp?" +  searchCriterion);
        }
    })
}