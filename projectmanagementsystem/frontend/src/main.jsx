import React from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import App from "./App";
import ReactDOM from "react-dom/client";
import Home from "./pages/Home";
import Admin from "./pages/Admin";
import Login from "./pages/Login";
import Company from "./pages/Company";
import "./index.css";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      {
        path: "/",
        element: <Home />,
      },
      {
        path: "/admin",
        element: <Admin />,
      },
      {
        path: "/login",
        element: <Login />,
      },
      {
        path: "/company",
        element: <Company />,
      },
    ],
  },
  {
    path: "/admin",
    element: <App />,
    // children: [
    //   {
    //     path: "/admin/employee",
    //     element: <Employee />,
    //   },
    // ],
  },
]);

const rootElement = document.getElementById("root");

if (rootElement) {
  const root = ReactDOM.createRoot(rootElement);
  root.render(
    <React.StrictMode>
      <RouterProvider router={router} />
    </React.StrictMode>
  );
} else {
  console.error("Root element not found");
}
