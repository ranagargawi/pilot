const loginForm = document.getElementById('login-form');
const signupForm = document.getElementById('signup-form');
const resultDiv = document.getElementById('result');

function showForm(form) {
  if (form === 'login') {
    loginForm.classList.remove('hidden');
    signupForm.classList.add('hidden');
  } else {
    signupForm.classList.remove('hidden');
    loginForm.classList.add('hidden');
  }
}

loginForm.addEventListener('submit', async (e) => {
  e.preventDefault();
  const email = document.getElementById('login-email').value;
  const password = document.getElementById('login-password').value;

  try {
    const res = await fetch('http://localhost:8080/auth/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ email, password })
    });

    const token = await res.text();
    resultDiv.textContent = res.ok ? `JWT Token: ${token}` : `Error: ${token}`;
  } catch (err) {
    resultDiv.textContent = `Network error: ${err.message}`;
  }
});

signupForm.addEventListener('submit', async (e) => {
  e.preventDefault();
  const email = document.getElementById('signup-email').value;
  const password = document.getElementById('signup-password').value;

  try {
    const res = await fetch('http://localhost:8080/auth/signup', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ email, password })
    });

    const token = await res.text();
    resultDiv.textContent = res.ok ? `JWT Token: ${token}` : `Error: ${token}`;
  } catch (err) {
    resultDiv.textContent = `Network error: ${err.message}`;
  }
});
