import React from 'react';
import { useNavigate } from 'react-router-dom'; // Importa useNavigate para la navegación
import 'bootstrap/dist/css/bootstrap.min.css'; // Asegúrate de importar Bootstrap

function HomeClient() {
  const navigate = useNavigate(); // Define navigate aquí

  return (
    <div className="container text-center mt-5">
      <h1>Bienvenido, Cliente</h1>
      <p>Esta es la sección para clientes.</p>
      
      {/* Botón para crear una nueva cuenta */}
      <button 
        className="btn btn-primary btn-lg mb-3" // Añadí mb-3 para espacio entre botones
        onClick={() => navigate('/client/add')}
      >
        ¿Eres nuevo?, crea una cuenta ahora.
      </button>
      
      {/* Botón para depositar o retirar dinero */}
      <button 
        className="btn btn-secondary btn-lg mb-3"
        onClick={() => navigate('/client/Histori/add')}
      >
        Deposita o retira tu dinero haciendo clic aquí.
      </button>

      {/* Botón para consultar la cuenta */}
      <button 
        className="btn btn-primary btn-lg mb-3"
        onClick={() => navigate('/client/TotalCost')}
      >
        ¿Quieres conocer el costo total de tu prestamo?, haz clic aquí.
      </button>

      {/* Botón para simular crédito */}
      <button 
        className="btn btn-primary btn-lg"
        onClick={() => navigate('/client/simulate')}
      >
        Simula tu crédito aquí.
      </button>

      <button 
          className="btn btn-secondary btn-lg" 
          onClick={() => navigate('/client/Request')}
        >
          Solicita tu prestamo aqui. 
        </button>

        <button 
          className="btn btn-secondary btn-lg" 
          onClick={() => navigate('/client/Follow')}
        >
          Realiza el seguimiento de tu solicitud. 
        </button>


    </div>
  );
}

export default HomeClient;
