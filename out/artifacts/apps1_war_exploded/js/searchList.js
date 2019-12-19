/**
 * Функция получает данные поля ввода критерия поиска 
 * и отправляет запрос сервлету на получение списка данных
 */
function getSearchResults() {

    var searchCriterion = document.getElementById("searchfield").value;
    var data = "searchCriterion=" + encodeURIComponent(searchCriterion);
    console.log("Получено значение " + document.getElementById("searchfield").value);
    sendData(data);



    // xhr.onload = function () {
    //   //  document.getElementById("test_field").value = xhr.responseText;
    //     document.getElementById("searchfield").value = xhr.responseText;
    // };


}

function sendData(data) {
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "ProductShowServlet");
    //xhr.responseType = "text";

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            console.log("Success " + xhr.responseText);
            document.getElementById("searchfield").value = xhr.responseText;
        }
        if (xhr.readyState === 1)
            console.log("Unsuccsess");
    };

    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(data);

}


