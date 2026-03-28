import React, { useState } from "react";
import axios from "axios";

function App() {
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [result, setResult] = useState("");
  const [error, setError] = useState("");

  const validateDate = (date) => {
    return /^\d{2}\/\d{2}\/\d{4}$/.test(date);
  };

  const calculateDays = async () => {
    setError("");
    setResult("");

    if (!validateDate(startDate) || !validateDate(endDate)) {
      setError("Invalid format. Use DD/MM/YYYY");
      return;
    }

    try {
      const res = await axios.post("http://localhost:8080/api/dates/days", {
        startDate,
        endDate,
      });
      setResult(res.data.days);
    } catch (err) {
      setError("Error calculating days");
    }
  };

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h2>Date Calculator</h2>

      <input
        placeholder="DD/MM/YYYY"
        value={startDate}
        onChange={(e) => setStartDate(e.target.value)}
      />
      <br /><br />

      <input
        placeholder="DD/MM/YYYY"
        value={endDate}
        onChange={(e) => setEndDate(e.target.value)}
      />
      <br /><br />

      <button onClick={calculateDays}>Calculate</button>

      <h3>{result && `Days: ${result}`}</h3>
      <p style={{ color: "red" }}>{error}</p>
    </div>
  );
}

export default App;