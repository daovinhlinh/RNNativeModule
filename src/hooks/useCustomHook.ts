import { useState } from "react"

export const useCustomHook = (value) => {
  const [state, setState] = useState(value)
  console.log('create custom hook');

  return {
    state,
    setState
  }
}