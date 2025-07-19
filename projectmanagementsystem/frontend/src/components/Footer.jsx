import React from "react";

const Footer = () => {
  return (
    <footer className="bg-indigo-800 text-white py-6 mt-10">
      <div className="max-w-7xl mx-auto px-4 flex flex-col md:flex-row justify-between items-center">
        <p className="text-sm">
          &copy; {new Date().getFullYear()} Project Management System. All
          rights reserved.
        </p>
        <div className="flex space-x-4 mt-4 md:mt-0">
          <a href="#" className="hover:text-yellow-300 text-sm transition">
            Privacy
          </a>
          <a href="#" className="hover:text-yellow-300 text-sm transition">
            Terms
          </a>
          <a href="#" className="hover:text-yellow-300 text-sm transition">
            Support
          </a>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
