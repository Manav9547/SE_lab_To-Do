# Simple Command Line To-Do List App

todo_list = []

def show_menu():
    print("\n==== TO-DO LIST MENU ====")
    print("1. View tasks")
    print("2. Add task")
    print("3. Remove task")
    print("4. Clear all tasks")
    print("5. Exit")

def view_tasks():
    if not todo_list:
        print("\nNo tasks added yet.")
    else:
        print("\nYour Tasks:")
        for i, task in enumerate(todo_list, start=1):
            print(f"{i}. {task}")

def add_task():
    task = input("\nEnter task: ")
    todo_list.append(task)
    print("Task added!")

def remove_task():
    view_tasks()
    try:
        task_no = int(input("\nEnter task number to remove: "))
        removed = todo_list.pop(task_no - 1)
        print(f"Removed: {removed}")
    except (ValueError, IndexError):
        print("Invalid selection.")

def clear_all():
    todo_list.clear()
    print("All tasks cleared!")

while True:
    show_menu()
    choice = input("\nChoose an option: ")

    if choice == "1":
        view_tasks()
    elif choice == "2":
        add_task()
    elif choice == "3":
        remove_task()
    elif choice == "4":
        clear_all()
    elif choice == "5":
        print("Goodbye!")
        break
    else:
        print("Invalid choice, try again.")
