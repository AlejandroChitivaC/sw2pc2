import React, { useState } from 'react';
import axios from 'axios';

const useProjectRegistrationForm = () => {
    const [projectName, setProjectName] = useState<string>('');
    const [projectNameError, setProjectNameError] = useState<string>('');

    const [projectDescription, setProjectDescription] = useState<string>('');
    const [projectDescriptionError, setProjectDescriptionError] = useState<string>('');

    const [budget, setBudget] = useState<string>('');
    const [budgetError, setBudgetError] = useState<string>('');

    const [startDate, setStartDate] = useState<Date | null>(null);
    const [startDateError, setStartDateError] = useState<string>('');

    const [endDate, setEndDate] = useState<Date | null>(null);
    const [endDateError, setEndDateError] = useState<string>('');

    const [projectStatus, setProjectStatus] = useState<string>('');
    const [projectStatusError, setProjectStatusError] = useState<string>('');

    const [projectLeader, setProjectLeader] = useState<string>('');
    const [projectLeaderError, setProjectLeaderError] = useState<string>('');

    const [successMessage, setSuccessMessage] = useState<string>('');
    const [errorMessage, setErrorMessage] = useState<string>('');
    const url = 'http://localhost:8080/projects/register';

    const handelNameChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const value = e.target.value;
        setProjectName(value);
        if (value.trim() === '') {
            setProjectNameError('El nombre del proyecto es requerido');
        } else {
            setProjectNameError('');
        }
    };

    const handelDescriptionChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const value = e.target.value;
        setProjectDescription(value);
        if (value.trim() === '') {
            setProjectDescriptionError('La descripción del proyecto es requerida');
        } else {
            setProjectDescriptionError('');
        }
    };

    const handelBudgetChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const value = e.target.value;
        setBudget(value);
        if (value.trim() === '') {
            setBudgetError('El presupuesto del proyecto es requerido');
        } else if (isNaN(Number(value))) {
            setBudgetError('El presupuesto debe ser un número válido');
        } else {
            setBudgetError('');
        }
    };

    const handleStartDateChange = (date: Date | null) => {
        setStartDate(date);
        if (!date) {
            setStartDateError('La fecha de inicio es requerida');
        } else {
            setStartDateError('');
        }
    };

    const handleEndDateChange = (date: Date | null) => {
        setEndDate(date);
        if (!date) {
            setEndDateError('La fecha de finalización es requerida');
        } else {
            setEndDateError('');
        }
    };

    const handleStatusChange = (status: string) => {
        setProjectStatus(status);
        if (status.trim() === '') {
            setProjectStatusError('El estado del proyecto es requerido');
        } else {
            setProjectStatusError('');
        }
    };

    const handleLeaderChange = (leader: string) => {
        setProjectLeader(leader);
        if (leader.trim() === '') {
            setProjectLeaderError('El líder del proyecto es requerido');
        } else {
            setProjectLeaderError('');
        }
    };

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        // Validaciones de campos
        if (!projectName.trim()) {
            setProjectNameError('El nombre del proyecto es requerido');
            return;
        }
        if (!projectDescription.trim()) {
            setProjectDescriptionError('La descripción del proyecto es requerida');
            return;
        }
        if (!budget.trim()) {
            setBudgetError('El presupuesto del proyecto es requerido');
            return;
        }
        if (!startDate) {
            setStartDateError('La fecha de inicio del proyecto es requerida');
            return;
        }
        if (!endDate) {
            setEndDateError('La fecha de finalización del proyecto es requerida');
            return;
        }
        if (!projectStatus) {
            setProjectStatusError('El estado del proyecto es requerido');
            return;
        }
        if (!projectLeader) {
            setProjectLeaderError('El líder del proyecto es requerido');
            return;
        }

        // Si todas las validaciones pasan, procede con el envío del formulario

        try {
            await axios.post(url, {
                projectName,
                projectDescription,
                budget,
                startDate,
                endDate,
                projectStatus,
                projectLeader,
            });
            setSuccessMessage('¡El proyecto se ha registrado exitosamente!');
            setErrorMessage(''); // Limpiar el mensaje de error si hay uno
        } catch (error) {
            // @ts-ignore
            if (error.response) {
                // @ts-ignore
                setErrorMessage('Error al registrar el proyecto: ${error.response.data.message}');
            } else {
                setErrorMessage('Error al registrar el proyecto: Ocurrió un error inesperado. Por favor, inténtelo de nuevo más tarde.');
            }
            setSuccessMessage(''); // Limpiar el mensaje de éxito si hubo un error
        }
    };

    return {
        projectName,
        projectNameError,
        projectDescription,
        projectDescriptionError,
        budget,
        budgetError,
        startDate,
        startDateError,
        endDate,
        endDateError,
        projectStatus,
        projectStatusError,
        projectLeader,
        projectLeaderError,
        successMessage,
        errorMessage,
        handleSubmit,
        handelNameChange,
        handelDescriptionChange,
        handelBudgetChange,
        handleStartDateChange,
        handleEndDateChange,
        handleStatusChange,
        handleLeaderChange,
    };
};

export default useProjectRegistrationForm;