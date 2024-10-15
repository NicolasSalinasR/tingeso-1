import React, { useState } from "react";
import RequestService from "../Service/Request.service";

const UpdateStageForm = () => {
    // Estados para ClientId y Stage
    const [clientId, setClientId] = useState('');
    const [stage, setStage] = useState('');
    const [message, setMessage] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            // Crear el cuerpo del request, asegurando que los valores sean cadenas
            const body = {
                ClientId: clientId.toString(),  // Convertir el ClientId a cadena
                Stage: stage.toString(),        // Convertir el Stage a cadena
            };

            // Llamar al servicio para actualizar el Stage
            const response = await RequestService.updateStage(body);
            setMessage(response.data); // Mostrar mensaje de éxito
        } catch (error) {
            if (error.response && error.response.status === 404) {
                setMessage('Request not found!');
            } else {
                setMessage('Error updating stage');
            }
        }
    };

    return (
        <div className="container mt-5">
            <h2>Actualizar Etapa de la Solicitud</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>ID del Cliente:</label>
                    <input 
                        type="number" 
                        className="form-control" 
                        value={clientId} 
                        onChange={(e) => setClientId(e.target.value)} 
                        required 
                    />
                </div>
                <div className="form-group">
                    <label>Nuevo Stage:</label>
                    <input 
                        type="number" 
                        className="form-control" 
                        value={stage} 
                        onChange={(e) => setStage(e.target.value)} 
                        required 
                    />
                </div>
                <button type="submit" className="btn btn-primary mt-3">Actualizar</button>
            </form>

            {message && <div className="alert alert-info mt-3">{message}</div>}
        </div>
    );
};

export default UpdateStageForm;
