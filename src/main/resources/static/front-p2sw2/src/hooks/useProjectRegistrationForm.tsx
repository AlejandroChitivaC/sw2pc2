import { useState } from 'react';
import axios from 'axios';
import { Report } from 'notiflix/build/notiflix-report-aio';
import { defaults } from 'flatpickr/dist/types/options';

const useProjectRegistrationForm = () => {
    const [projectName, setProjectName] = useState<string>('');
    const [projectDescription, setProjectDescription] = useState<string>('');
    const [budget, setBudget] = useState<string>('');
    const [startDate, setStartDate] = useState<Date | null>(null);
    const [endDate, setEndDate] = useState<Date | null>(null);
    const [projectStatus, setProjectStatus] = useState<string>('');
    const [projectLeader, setProjectLeader] = useState<string>(''); // Estado para el líder del proyecto
    const url = '';

    const handelNameChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setProjectName(e.target.value);
    };

    const handelDescriptionChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setProjectDescription(e.target.value);
    };

    const handelBudgetChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setBudget(e.target.value);
    };

    const handleStartDateChange = (date: Date | null) => {
        setStartDate(date);
    };

    const handleEndDateChange = (date: Date | null) => {
        setEndDate(date);
    };

    const handleStatusChange = (Status: string) => {
        setProjectStatus(Status);
    };

    const handleLeaderChange = (leader: string) => {
        setProjectLeader(leader);
    };

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        // Lógica de envío de datos
    };

    return {
        projectName,
        projectDescription,
        budget,
        startDate,
        endDate,
        projectStatus,
        projectLeader,
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
