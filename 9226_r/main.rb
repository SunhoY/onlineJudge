while string = gets.strip
  break if string == '#'

  index = string.index(/[aeiou]/) || 0
  first = string[0, index]
  last = string[index, string.length]

  puts "#{last}#{first}ay"
end