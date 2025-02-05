// Task: Develop a function that processes a sequence of customer support tickets represented as strings. Each ticket has a format 'ID:priority:department'
// (e.g., 'T123:1:billing'). The function should reorder tickets based on the following rules: 1. Higher priority tickets (1 being highest, 3 being lowest)
// should be handled first 2. Within the same priority, tickets should maintain their original order (FIFO) 3. If a ticket is marked for the 'urgent' department,
// it should be moved to the front of its priority group

function displayTickets(arr) {
  // first sort each ticket by ticket number
  for (let i = 0; i < arr.length; i++) {
    for (let k = 0; k < arr.length - 1 - i; k++) {
      if (
        arr[k].split(":")[0].replace("T", "") >
        arr[k + 1].split(":")[0].replace("T", "")
      ) {
        [arr[k], arr[k + 1]] = [arr[k + 1], arr[k]];
      }
    }
  }

  // then create variables to seperate urgent from non-urgent tickets
  const urgentTickets = [];
  const regularTickets = [];

  // fill arrays for urgent and non-urgent tickets
  for (let i = 0; i < arr.length; i++) {
    if (arr[i].split(":")[2] === "urgent") {
      urgentTickets.push(arr[i]);
    } else {
      regularTickets.push(arr[i]);
    }
  }

  // sort urgent tickets by priority number
  for (let i = 0; i < urgentTickets.length; i++) {
    for (let k = 0; k < urgentTickets.length - 1 - i; k++) {
      if (urgentTickets[k].split(":")[1] > urgentTickets[k + 1].split(":")[1]) {
        [urgentTickets[k], urgentTickets[k + 1]] = [
          urgentTickets[k + 1],
          urgentTickets[k],
        ];
      }
    }
  }

  // sort non-urgent tickets by priority number
  for (let i = 0; i < regularTickets.length; i++) {
    for (let k = 0; k < regularTickets.length - 1 - i; k++) {
      if (
        regularTickets[k].split(":")[1] > regularTickets[k + 1].split(":")[1]
      ) {
        [regularTickets[k], regularTickets[k + 1]] = [
          regularTickets[k + 1],
          regularTickets[k],
        ];
      }
    }
  }

  // send both arrays as one array
  const sortedTickets = [...urgentTickets, ...regularTickets];
  return sortedTickets;
}

// starting data
data = [
  "T124:3:urgent",
  "T125:2:billing",
  "T126:3:billing",
  "T128:1:staffing",
  "T129:1:urgent",
  "T127:1:urgent",
];

// expected output:
/**
 * T127:1:urgent
 * T129:1:urgent //this ticket is second because although it has same priority, it was created second
 * T124:3:urgent
 * T128:1:staffing
 * T125:2:billing
 * T126:3:billing
 */

console.log(displayTickets(data));
