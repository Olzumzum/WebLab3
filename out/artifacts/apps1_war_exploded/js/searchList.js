/**
 * Функция получает данные поля ввода критерия поиска 
 * и отправляет запрос сервлету на получение списка данных
 */
function getSearchResults(element) {

    /** получаем строковое значение критерия поиска */
    var criterion = element;

    /** получаем значение поисковой строки */
    var searchCriterion = document.getElementById("searchfield").value;

    if(!criterion.localeCompare(searchCriterion)) {
        console.log("Ищем по критерию поиска");
    } else {
        if(!criterion.localeCompare("Ассортимент")){
            console.log("Выводим весь список")
        } else {
            console.log("Выводим по критерию ассортимента");
        }
    }

    // var
    // var data = "searchCriterion=" + encodeURIComponent(searchCriterion);
    // console.log("Получено значение " + document.getElementById("searchfield").value);
    // sendData(data);



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


