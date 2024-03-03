import openai
import jpype
import os

def generate_tests_from_openai(openai_api_key, max_tokens=1000):
    # Initialize OpenAI API key
    openai.api_key = openai_api_key

    directory = 'C:\\Users\\Administrator\\Desktop\\output\\'
    for filename in os.listdir(directory):
        if filename.endswith(".txt") and not filename.startswith("tests_"):
            with open(os.path.join(directory, filename), 'r') as file:
                input_text = file.read()
                # Use the input_text here for further processing
                prompt = f"Generate TestNG code for the following java function, prepare @test methods in a class: \n{input_text}"
                response = openai.chat.completions.create(
                    model="gpt-3.5-turbo",
                    # prompt=prompt,
                    messages=[
                    {
                        "role": "user",
                        "content": prompt,
                    }
                ],
                    max_tokens=max_tokens
                )

                # Extract and return the generated summary
                generated_tests = response.choices[0].message.content.strip()
                print(generated_tests)
                # Write generated_tests to file
                output_file = os.path.join(directory, "tests_" + filename)
                with open(output_file, 'w') as file:
                    file.write(generated_tests)
                    print("Writing this to file: " + output_file)
                print("====================Generating tests done====================")
    print("All functions processed!")


openai_api_key = "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"
generate_tests_from_openai(openai_api_key)