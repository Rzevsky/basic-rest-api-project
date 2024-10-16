document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('studentForm').addEventListener('submit', async (e) => {
        e.preventDefault();
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;

        const response = await fetch('/api/students', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ name, email })
        });

        if (response.ok) {
            alert('Student added successfully!');
            loadStudents();
        }
    });

    async function loadStudents() {
        const response = await fetch('/api/students');
        const students = await response.json();
        const studentList = document.getElementById('studentList');
        studentList.innerHTML = '';
        students.forEach(student => {
            const li = document.createElement('li');
            li.textContent = `${student.name} (${student.email})`;
            studentList.appendChild(li);
        });
    }

    loadStudents();
});
