// Счетчик для отслеживания количества форм
let formCount = 2;

// Функция для добавления новой формы
document.getElementById('add-form').addEventListener('click', addForm);

function addForm() {
    // Создаем новый контейнер для формы
    const formContainer = document.createElement('div');
    formContainer.className = 'form-container';

    // Создаем и добавляем label и input
    const label = document.createElement('label');
    label.setAttribute('for', 'input' + formCount);
    label.textContent = 'Введите n' + formCount + ':';
    formContainer.appendChild(label);

    const input = document.createElement('input');
    input.type = 'number';
    input.id = 'input' + formCount;
    input.name = 'input' + formCount;
    input.min = '0';
    input.setAttribute('required', '');
    formContainer.appendChild(input);

    // Добавляем новый контейнер формы
    document.getElementById('forms').appendChild(formContainer);

    formCount++;
}

// Функция для удаления последней формы
function deleteLastForm() {
    const lastForm = document.querySelector('.form-container:last-child');
    if (lastForm) {
        lastForm.remove();
        renumberInputs();
    }
}

// Функция для переиндексации инпутов после удаления
function renumberInputs() {
    const formContainers = document.querySelectorAll('.form-container');
    formContainers.forEach((container, index) => {
        const label = container.querySelector('label');
        const input = container.querySelector('input');
        label.textContent = 'Введите n' + (index + 1) + ':';
        input.id = 'input' + (index + 1);
        input.name = 'input' + (index + 1);
    });
    formCount = formContainers.length + 1; // Обновляем счетчик
}

// Добавляем контейнер для форм в HTML
const formsContainer = document.createElement('div');
formsContainer.id = 'forms';
document.body.appendChild(formsContainer);

// Добавляем кнопку удаления последней формы в HTML
const deleteButton = document.getElementById("delete-button")
deleteButton.addEventListener('click', deleteLastForm);