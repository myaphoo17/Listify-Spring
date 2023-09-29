// DOM elements
const inputButton = document.querySelector(".input");
const addButton = document.querySelector(".addButton");
const taskList = document.querySelector(".taskList");

// Task data
let tasks = JSON.parse(localStorage.getItem("tasks")) || [];

// Save tasks to localStorage
function saveTasksToLocal() {
  localStorage.setItem("tasks", JSON.stringify(tasks));
}

// Render tasks
function renderTasks() {
  taskList.innerHTML = "";

  tasks.forEach((task, index) => {
    const item = document.createElement("li");
    item.className = "task";

    item.innerHTML = `
      <input type="checkbox" class="checkbox" ${
      task.completed ? 'checked="checked"' : ""
    }>
      <span class="text"> ${task.text}</span>
      <button class="editButton" >✏️</button>
      <button class="deleteButton">🗑️</button>
    `;

    const editButton = item.querySelector(".editButton");
    const deleteButton = item.querySelector(".deleteButton");
    const checkbox = item.querySelector(".checkbox");

    // Event listener for editing a task
    editButton.addEventListener("click", () => {
      const taskText = item.querySelector(".text");
      taskText.style.display = "none";
      const taskInput = document.createElement("input");
      taskInput.type = "text";
      taskInput.value = task.text;
      item.insertBefore(taskInput, taskText);
      taskInput.focus();

      taskInput.addEventListener("blur", () => {
        task.text = taskInput.value;
        saveTasksToLocal();
        renderTasks();
      });
    });

    // Event listener for deleting a task
    deleteButton.addEventListener("click", () => {
      tasks.splice(index, 1);
      saveTasksToLocal();
      renderTasks();
    });

    // Event listener for marking a task as completed
    checkbox.addEventListener("change", () => {
      task.completed = checkbox.checked;
      saveTasksToLocal();
      renderTasks();
    });

    taskList.appendChild(item);
  });
}

// Event listener for adding a new task
addButton.addEventListener("click", (event) => {
  event.preventDefault();

  const taskText = inputButton.value.trim();
  if (taskText) {
    console.log("Fetching data from:", '/api/tasks');
    fetch('/api/tasks', {
      credentials: 'include',
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ text: taskText, completed: false }),
    })
      .then(response => {
        if (!response.ok) {
          throw new Error(`Failed to create task: ${response.status}`);
        }
        return response.json();
      })
      .then(data => {
        tasks.push(data);
        saveTasksToLocal();
        renderTasks();
        inputButton.value = '';
      })
      .catch(error => {
        // Display an error message to the user or log it for debugging
        console.error("Fetch Error:", error);
        alert("An error occurred while creating the task. Please try again.");
      });
  }
});

// Initial rendering of tasks
renderTasks();
