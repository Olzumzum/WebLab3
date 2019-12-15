function searchList(form) {

    var searchCriterion = document.getElementById("searchfield").value;
    var data = "searchCriterion=" + encodeURIComponent(searchCriterion);
    console.log("Получено значение " + document.getElementById("searchfield").value);
    var xhr = new XMLHttpRequest();

    xhr.open('POST', 'ProductShowServlet', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(data);
}



function sendDateAjax(searchCriterion){


}