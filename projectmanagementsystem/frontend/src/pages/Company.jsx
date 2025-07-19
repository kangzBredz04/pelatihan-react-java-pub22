import React, { useEffect, useState } from "react";
import { FaPlus, FaEdit, FaTrash, FaTimes } from "react-icons/fa";

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL;

const Company = () => {
  const [companies, setCompanies] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [showForm, setShowForm] = useState(false);
  const [editMode, setEditMode] = useState(false);
  const [selectedCompany, setSelectedCompany] = useState(null);
  const [newCompany, setNewCompany] = useState({ name: "", address: "" });

  useEffect(() => {
    fetchCompanies();
  }, []);

  const fetchCompanies = () => {
    setLoading(true);
    fetch(`${API_BASE_URL}/company/all`)
      .then((response) => {
        if (!response.ok)
          throw new Error(`HTTP error! status: ${response.status}`);
        return response.json();
      })
      .then((data) => {
        setCompanies(data);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  };

  const handleInputChange = (e) => {
    setNewCompany({ ...newCompany, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const url = editMode
      ? `${API_BASE_URL}/company/update/${selectedCompany.id}`
      : `${API_BASE_URL}/company/create`;

    const method = editMode ? "PUT" : "POST";

    fetch(url, {
      method,
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newCompany),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to save company");
        return res.json();
      })
      .then(() => {
        setShowForm(false);
        setEditMode(false);
        setSelectedCompany(null);
        setNewCompany({ name: "", address: "" });
        fetchCompanies();
        alert("Company saved successfully");
      })
      .catch((err) => alert("Error: " + err.message));
  };

  const handleDelete = (id) => {
    if (!confirm("Are you sure to delete this company?")) return;

    fetch(`${API_BASE_URL}/company/delete/${id}`, { method: "DELETE" })
      .then((res) => {
        if (!res.ok) throw new Error("Delete failed");
        fetchCompanies();
        alert("Deleted successfully");
      })
      .catch((err) => alert("Error: " + err.message));
  };

  const handleEdit = (company) => {
    setSelectedCompany(company);
    setNewCompany({ name: company.name, address: company.address });
    setEditMode(true);
    setShowForm(true);
  };

  return (
    <div className="bg-gray-100 flex flex-col items-center py-10 px-4">
      <div className="bg-white shadow-lg rounded-lg w-full max-w-4xl p-4">
        <div className="flex justify-between items-center mb-4">
          <h2 className="text-xl font-bold text-gray-800">Company List</h2>
          <button
            onClick={() => {
              setShowForm(true);
              setEditMode(false);
              setNewCompany({ name: "", address: "" });
            }}
            className="bg-blue-600 text-white px-3 py-1.5 rounded hover:bg-blue-700 flex items-center gap-2"
          >
            <FaPlus /> Add Company
          </button>
        </div>

        {loading && <p className="text-blue-500">Loading data...</p>}
        {error && <p className="text-red-500">Error: {error}</p>}

        {!loading && !error && (
          <div className="overflow-x-auto">
            <table className="min-w-full bg-white border border-gray-300 text-sm rounded-lg">
              <thead>
                <tr className="bg-gray-200 text-gray-700">
                  <th className="px-4 py-2 text-left">ID</th>
                  <th className="px-4 py-2 text-left">Company Name</th>
                  <th className="px-4 py-2 text-left">Address</th>
                  <th className="px-4 py-2 text-left">Actions</th>
                </tr>
              </thead>
              <tbody>
                {companies.map((company, index) => (
                  <tr
                    key={company.id}
                    className={index % 2 === 0 ? "bg-white" : "bg-gray-50"}
                  >
                    <td className="px-4 py-2 border-t">{company.id}</td>
                    <td className="px-4 py-2 border-t">{company.name}</td>
                    <td className="px-4 py-2 border-t">{company.address}</td>
                    <td className="px-4 py-2 border-t space-x-2">
                      <button
                        onClick={() => handleEdit(company)}
                        className="text-yellow-600 hover:text-yellow-800"
                      >
                        <FaEdit />
                      </button>
                      <button
                        onClick={() => handleDelete(company.id)}
                        className="text-red-600 hover:text-red-800"
                      >
                        <FaTrash />
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>

      {/* Modal Form with Blur */}
      {showForm && (
        <div className="fixed inset-0 backdrop-blur-sm bg-white/30 flex items-center justify-center z-50">
          <div className="bg-white rounded-lg shadow-lg w-full max-w-md p-6 relative">
            <button
              onClick={() => {
                setShowForm(false);
                setEditMode(false);
                setNewCompany({ name: "", address: "" });
              }}
              className="absolute top-2 right-3 text-gray-500 hover:text-red-600 text-lg"
            >
              <FaTimes />
            </button>
            <h3 className="text-lg font-semibold mb-4">
              {editMode ? "Edit Company" : "Add New Company"}
            </h3>
            <form onSubmit={handleSubmit} className="space-y-4">
              <div>
                <label className="block text-sm text-gray-600 mb-1">
                  Company Name
                </label>
                <input
                  type="text"
                  name="name"
                  value={newCompany.name}
                  onChange={handleInputChange}
                  required
                  className="w-full px-3 py-2 border rounded focus:outline-none focus:ring"
                />
              </div>
              <div>
                <label className="block text-sm text-gray-600 mb-1">
                  Address
                </label>
                <input
                  type="text"
                  name="address"
                  value={newCompany.address}
                  onChange={handleInputChange}
                  required
                  className="w-full px-3 py-2 border rounded focus:outline-none focus:ring"
                />
              </div>
              <button
                type="submit"
                className="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700"
              >
                {editMode ? "Update" : "Submit"}
              </button>
            </form>
          </div>
        </div>
      )}
    </div>
  );
};

export default Company;
