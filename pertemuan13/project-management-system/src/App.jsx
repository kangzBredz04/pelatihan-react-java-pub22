import { Outlet } from "react-router-dom";

function App() {
  return (
    <div className="min-h-screen flex flex-col bg-[#f9fafb] text-gray-800 font-sans">
      {/* Header */}
      <header className="bg-white shadow-md">
        <div className="max-w-7xl mx-auto px-6 py-5 flex justify-between items-center">
          <h1 className="text-2xl sm:text-3xl font-bold text-indigo-700 tracking-tight">
            🚀 Project Management System
          </h1>
          <nav className="hidden sm:flex space-x-6 text-sm font-medium text-gray-600">
            <a href="/" className="hover:text-indigo-600 transition">
              Home
            </a>
            <a href="/projects" className="hover:text-indigo-600 transition">
              Projects
            </a>
            <a href="/team" className="hover:text-indigo-600 transition">
              Team
            </a>
            <a href="/contact" className="hover:text-indigo-600 transition">
              Contact
            </a>
          </nav>
        </div>
      </header>

      {/* Main Content */}
      <main className="flex-grow max-w-7xl mx-auto w-full px-6 py-10">
        <div className="bg-white rounded-2xl shadow-sm p-6 md:p-10 transition hover:shadow-md">
          <Outlet />
        </div>
      </main>

      {/* Footer */}
      <footer className="bg-gradient-to-r from-indigo-700 to-purple-700 text-white text-center py-6 mt-10">
        <p className="text-sm">
          &copy; {new Date().getFullYear()}{" "}
          <span className="font-semibold">Project Management System</span>. All
          rights reserved.
        </p>
      </footer>
    </div>
  );
}

export default App;
