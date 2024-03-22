import React, { useState, useEffect } from 'react';
import axios from 'axios';

const SelectGroupOne: React.FC<{ labelText: string; selectPlaceholder: string; onChange: (leader: string) => void }> = ({ labelText, selectPlaceholder, onChange }) => {
  const [selectedOption, setSelectedOption] = useState<string>('');
  // @ts-ignore
  const [isOptionSelected, setIsOptionSelected] = useState<boolean>(false);
  const [options, setOptions] = useState<string[]>([]);

  const changeTextColor = () => {
    setIsOptionSelected(true);
  };

  useEffect(() => {
    const fetchOptions = async () => {
      try {
        const response = await axios.get('/api/options'); // Hacer solicitud HTTP al endpoint del backend
        setOptions(response.data);
      } catch (error) {
        console.error('Error fetching options:', error);
      }
    };

    fetchOptions();
  }, []);

  const handleChange = (e: React.FormEvent<HTMLSelectElement>) => {
    const leader = e.currentTarget.value; // Acceder al valor del formulario
  };

  return (
      <div className="mb-4.5">
        <label className="mb-2.5 block text-black dark:text-white">
          {labelText}
        </label>

        <div className="relative z-20 bg-transparent dark:bg-form-input">
          <select
              value={selectedOption}
              onChange={(e) => {
                setSelectedOption(e.target.value);
                changeTextColor(); // Llamar a la función para cambiar el color del texto
                onChange(e.target.value);
                handleChange(e);
              }}
              className="relative z-20 w-full appearance-none rounded border border-stroke bg-transparent py-3 px-5 outline-none transition focus:border-primary active:border-primary dark:border-form-strokedark dark:bg-form-input dark:focus:border-primary"
          >
            <option value="" disabled>
              {selectPlaceholder}
            </option>
            {options.map((option, index) => (
                <option key={index} value={option}>
                  {option}
                </option>
            ))}
          </select>

          <span className="absolute top-1/2 right-4 z-30 -translate-y-1/2">
          <svg
              className="fill-current"
              width="24"
              height="24"
              viewBox="0 0 24 24"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
          >
            <g opacity="0.8">
              <path
                  fillRule="evenodd"
                  clipRule="evenodd"
                  d="M5.29289 8.29289C5.68342 7.90237 6.31658 7.90237 6.70711 8.29289L12 13.5858L17.2929 8.29289C17.6834 7.90237 18.3166 7.90237 18.7071 8.29289C19.0976 8.68342 19.0976 9.31658 18.7071 9.70711L12.7071 15.7071C12.3166 16.0976 11.6834 16.0976 11.2929 15.7071L5.29289 9.70711C4.90237 9.31658 4.90237 8.68342 5.29289 8.29289Z"
              ></path>
            </g>
          </svg>
        </span>
        </div>
      </div>
  );
};

export default SelectGroupOne;
