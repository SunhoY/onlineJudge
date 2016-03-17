inputs = Array.new
suffix = 'ay'

File.readlines('input').each do |line|
  inputs.push(line)
end

inputs.each do |input|
  input.strip!

  if input == '#'
    break
  end

  index = input.index(/[aeiou]/) || 0
  first = input[0, index]
  last = input[index, input.length]

  puts "#{first}#{last}#{suffix}"
end

