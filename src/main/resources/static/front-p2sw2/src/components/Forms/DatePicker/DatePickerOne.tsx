import flatpickr from 'flatpickr';
import { useEffect, useRef } from 'react';

interface DatePickerProps {
  label: string;
  value: Date;
  onChange: (date: Date) => void;
}

const DatePickerOne = ({ label, value, onChange }: DatePickerProps) => {
  const inputRef = useRef<HTMLInputElement>(null);

  useEffect(() => {
    const instance = flatpickr(inputRef.current!, {
      mode: 'single',
      static: true,
      monthSelectorType: 'static',
      dateFormat: 'Y-m-d',
      prevArrow:
        '<svg className="fill-current" width="7" height="11" viewBox="0 0 7 11"><path d="M5.4 10.8l1.4-1.4-4-4 4-4L5.4 0 0 5.4z" /></svg>',
      nextArrow:
        '<svg className="fill-current" width="7" height="11" viewBox="0 0 7 11"><path d="M1.4 10.8L0 9.4l4-4-4-4L1.4 0l5.4 5.4z" /></svg>',
      onChange: (selectedDates: Date[] | undefined) => {
        if (selectedDates && selectedDates.length > 0) {
          onChange(selectedDates[0]);
        }
      },
    });

    return () => {
      instance.destroy();
    };
  }, [onChange]);

  return (
    <div>
      <label className="mb-3 block text-sm font-medium text-black dark:text-white">
        {label}
      </label>
      <div className="relative">
        <input
          ref={inputRef}
          className="form-datepicker w-full rounded border-[1.5px] border-stroke bg-transparent px-5 py-3 font-normal outline-none transition focus:border-primary active:border-primary dark:border-form-strokedark dark:bg-form-input dark:focus:border-primary"
          type="text"
          placeholder="yyyy/mm/dd"
          data-class="flatpickr-right"
        />
      </div>
    </div>
  );
};

export default DatePickerOne;