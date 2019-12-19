/**
 * Функция получает данные поля ввода критерия поиска 
 * и отправляет запрос сервлету на получение списка данных
 */
function getSearchResults(element) {
    var data;

    /** получаем строковое значение критерия поиска */
    var criterion = element;
    console.log("Получено значение " + criterion);

    /** получаем значение поисковой строки */
    var searchCriterion = document.getElementById("searchfield").value;

    /** сравниваем полученное значение со значением в поисковой строке
     * и словом "Ассортимент" - ключевым словом для вывода всего списка
     */
    if(!criterion.localeCompare(searchCriterion)) {
        console.log("Ищем по критерию поиска");
        data = "searchCriterion=" + encodeURIComponent(criterion);
    } else {
        if(!criterion.localeCompare("Ассортимент")){
            console.log("Выводим весь список");
            data = "assort=all";
        } else {
            console.log("Выводим по критерию ассортимента");
            data = "assort=" +  encodeURIComponent(criterion);
        }
    }

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


