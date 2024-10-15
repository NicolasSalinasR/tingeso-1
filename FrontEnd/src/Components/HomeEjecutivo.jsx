import React, { useState, useEffect } from 'react';
import requestService from '../Service/Request.service';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from 'react-router-dom'; // Importa useNavigate para la navegación

const HomeEjecutivo = () => {
  const navigate = useNavigate();
  const [requests, setRequests] = useState([]);

  // Función para obtener todas las solicitudes desde el backend
  const fetchAllRequests = async () => {
    try {
      const response = await requestService.getAllRequests();
      setRequests(response.data);
    } catch (error) {
      console.error('Error al obtener las solicitudes', error);
      setRequests([]);
    }
  };

  useEffect(() => {
    fetchAllRequests(); // Obtener todas las solicitudes cuando el componente se monta
  }, []);

  return (
    <div className="container mt-5 d-flex justify-content-center">
      <div className="w-75">
        <h2 className="text-center mb-4">Todas las Solicitudes</h2>
        {requests.length > 0 ? (
          <table className="table table-bordered table-hover table-striped text-center">
            <thead className="thead-dark">
              <tr>
                <th>Id</th>
                <th>ClientId</th>
                <th>Stage</th>
                <th>Amount</th>
                <th>Year Term</th>
                <th>Acciones</th> {/* Nueva columna para los botones de acción */}
              </tr>
            </thead>
            <tbody>
              {requests.map((request) => (
                <tr key={request.id}>
                  <td>{request.id}</td>
                  <td>{request.clientId}</td>
                  <td>{request.stage}</td>
                  <td>{request.amount}</td>
                  <td>{request.yearTerm}</td>
                  <td>
                    <button 
                      className="btn btn-primary btn-sm" 
                      onClick={() => navigate('/Ejecutivo/Request/Update')}
                    >
                      Actualizar la solicitud
                    </button>

                    <button 
                      className="btn btn-danger btn-sm"
                      onClick={() => navigate('/Ejecutivo/Request/Conditions', { 
                        state: { 
                          clientId: request.clientId, 
                          amount: request.amount, 
                          yearTerm: request.yearTerm 
                        } 
                      })}
                    >
                      Comprobar condiciones para la solicitud
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        ) : (
          <p className="text-center">No se encontraron solicitudes.</p>
        )}
      </div>
    </div>
  );
};

export default HomeEjecutivo;
