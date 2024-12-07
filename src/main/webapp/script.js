let formCount = 2;

document.getElementById('add-form').addEventListener('click', addForm);

function addForm() {

    const formContainer = document.createElement('div');
    formContainer.className = 'form-container';

    const label = document.createElement('label');
    label.setAttribute('for', 'input' + formCount);
    label.textContent = 'Input n' + formCount + ':';
    formContainer.appendChild(label);

    const input = document.createElement('input');
    input.type = 'number';
    input.id = 'input' + formCount;
    input.name = 'input' + formCount;
    input.min = '0';
    input.setAttribute('required', '');
    formContainer.appendChild(input);

    document.getElementById('forms').appendChild(formContainer);

    formCount++;
}

function deleteLastForm() {
    const lastForm = document.querySelector('.form-container:last-child');
    if (lastForm) {
        lastForm.remove();
        renumberInputs();
    }
}

function renumberInputs() {
    const formContainers = document.querySelectorAll('.form-container');
    formContainers.forEach((container, index) => {
        const label = container.querySelector('label');
        const input = container.querySelector('input');
        label.textContent = 'Input n' + (index + 1) + ':';
        input.id = 'input' + (index + 1);
        input.name = 'input' + (index + 1);
    });
    formCount = formContainers.length + 1;
}

const formsContainer = document.createElement('div');
formsContainer.id = 'forms';
document.body.appendChild(formsContainer);


const deleteButton = document.getElementById("delete-button")
deleteButton.addEventListener('click', deleteLastForm);