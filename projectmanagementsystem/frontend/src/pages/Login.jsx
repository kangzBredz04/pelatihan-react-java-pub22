import { useState } from "react";
import { FaUserAlt, FaLock } from "react-icons/fa";

function Login() {
  const [form, setForm] = useState({ email: "", password: "" });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!form.email || !form.password) {
      alert("Please fill in all fields.");
      return;
    }

    alert(`Logging in with: ${form.email}`);
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-gradient-to-br from-blue-500 to-indigo-600 px-4">
      <div className="w-full max-w-md bg-white/10 backdrop-blur-md border border-white/20 rounded-2xl shadow-2xl p-8 text-white">
        <h2 className="text-3xl font-bold text-center mb-6 tracking-wide">
          Login
        </h2>
        <form onSubmit={handleSubmit} className="space-y-5">
          <div className="flex items-center bg-white/10 border border-white/20 rounded-lg px-4 py-2 focus-within:ring-2 focus-within:ring-blue-400 transition">
            <FaUserAlt className="text-white/60 mr-3" />
            <input
              type="email"
              name="email"
              placeholder="Email"
              value={form.email}
              onChange={handleChange}
              className="w-full bg-transparent outline-none text-white placeholder-white/50"
              required
            />
          </div>
          <div className="flex items-center bg-white/10 border border-white/20 rounded-lg px-4 py-2 focus-within:ring-2 focus-within:ring-blue-400 transition">
            <FaLock className="text-white/60 mr-3" />
            <input
              type="password"
              name="password"
              placeholder="Password"
              value={form.password}
              onChange={handleChange}
              className="w-full bg-transparent outline-none text-white placeholder-white/50"
              required
            />
          </div>
          <button
            type="submit"
            className="w-full bg-blue-600 hover:bg-blue-700 text-white py-2 rounded-lg shadow-md hover:shadow-xl transition duration-300"
          >
            Login
          </button>
        </form>
      </div>
    </div>
  );
}

export default Login;
