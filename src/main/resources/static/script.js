function addTodo() {
    const title = prompt("Введите текст:");

    fetch("/api/todos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            title: title
        })
    }).then(r => {
        if (r.ok) {
            location.reload(); // обновляем страницу после удаления
        } else {
            alert("Ошибка добавления");
        }
    });
}
function updateStatus(checkbox) {
    const id = checkbox.getAttribute('data-id');
    const completed = checkbox.checked;
    const title = checkbox.parentElement.querySelector('span').innerText;

    fetch("/api/todos/" + id, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id: id,
            title: title,
            completed: completed
        })
    }).then(r => {
        if (r.ok) {
            location.reload(); // обновляем страницу после удаления
        } else {
            alert("Ошибка обновления");
        }
    });

}
function deleteTodo(id) {
    fetch("/api/todos/" + id, {
        method: "DELETE"
    }).then(r => {
        if (r.ok) {
            location.reload(); // обновляем страницу после удаления
        } else {
            alert("Ошибка удаления");
        }
    });
    return false; // предотвратить переход по ссылке
}