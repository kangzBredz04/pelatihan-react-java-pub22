import { Outlet } from "react-router-dom";

function App() {
  return (
    <>
      <header>
        <nav>
          <ul>
            <li>
              <a href="/">Home</a>
            </li>
            <li>
              <a href="/admin">Admin</a>
            </li>
            <li>
              <a href="/login">Login</a>
            </li>
            <li>
              <a href="/company">Company</a>
            </li>
          </ul>
        </nav>
      </header>
      <Outlet />
      <footer>
        <h1>Ini adalah footer</h1>
      </footer>
    </>
  );
}

export default App;
