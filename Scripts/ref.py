import re

def capitalize_title(title):
    # Preserve braces and capitalize only outside them
    def preserve_case(match):
        return '{' + match.group(1) + '}'

    # Protect content in curly braces
    protected = re.sub(r'\{([^}]+)\}', preserve_case, title)
    words = protected.split()
    result = []
    for word in words:
        if word.startswith('{') and word.endswith('}'):
            result.append(word)  # Already preserved
        else:
            result.append(word.capitalize())
    return ' '.join(result)

def format_field(entry_text, field_name):
    pattern = re.compile(rf'({field_name}\s*=\s*\{{)([^{{}}]+)(\}})', re.IGNORECASE)
    return pattern.sub(lambda m: m.group(1) + capitalize_title(m.group(2)) + m.group(3), entry_text)

def format_entry(entry_body):
    entry_body = format_field(entry_body, "title")
    entry_body = format_field(entry_body, "journal")
    entry_body = format_field(entry_body, "booktitle")
    return entry_body

def format_bibtex_file(input_path, output_path):
    with open(input_path, 'r', encoding='utf-8') as f:
        content = f.read()

    entries = re.split(r'@(?=\w+\{)', content)
    formatted_entries = []
    for entry in entries:
        if entry.strip():
            entry_type_and_body = entry.strip().split('{', 1)
            if len(entry_type_and_body) == 2:
                entry_type, body = entry_type_and_body
                formatted_entry = '@' + entry_type + '{' + format_entry(body)
                formatted_entries.append(formatted_entry)

    with open(output_path, 'w', encoding='utf-8') as f:
        f.write('\n\n'.join(formatted_entries))

# Usage
input_file = 'bibtex.bib'
output_file = 'formatted_bibtex.bib'
format_bibtex_file(input_file, output_file)
